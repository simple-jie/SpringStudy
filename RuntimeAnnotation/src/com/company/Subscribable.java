package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Subscribable {
    private static Subscribable _INSTANCE;

    private HashMap<Object, List<RegisterInfo>> registerInfo;

    private Subscribable() {
        registerInfo = new HashMap<>();
    }

    public static Subscribable INSTANCE() {
        if (_INSTANCE == null) {
            synchronized (Subscribable.class) {
                if (_INSTANCE == null) {
                    _INSTANCE = new Subscribable();
                }
            }
        }

        return _INSTANCE;
    }

    private class RegisterInfo {
        RegisterInfo(Method method, List<Type> types) {
            this.method = method;
            this.types = types;
        }

        Method method;
        List<Type> types;
    }

    public void post(Type type) {
        registerInfo.forEach((o, infos) -> infos.forEach(info -> {
                    if (info.types.contains(type)) {
                        try {
                            info.method.invoke(o, type);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ));
    }

    public void register(Object o) {
        if (o == null)
            return;

        if (registerInfo.containsKey(o))
            return;

        Method[] methods = o.getClass().getMethods();
        List<RegisterInfo> infos = null;
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            MySubscribe mySubscribe = method.getDeclaredAnnotation(MySubscribe.class);
            if (mySubscribe != null) {
                if (mySubscribe.value().length > 0) {
                    if (infos == null) {
                        infos = new ArrayList<>();
                        registerInfo.put(o, infos);
                    }

                    infos.add(new RegisterInfo(method, Arrays.asList(mySubscribe.value())));
                }
            }
        }
    }
}
