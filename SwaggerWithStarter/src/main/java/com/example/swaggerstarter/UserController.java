package com.example.swaggerstarter;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    static Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseWrapper<List<User>> getUserList() {
        return new ResponseWrapper<>("ok", "success", new ArrayList<>(userMap.values()));
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(
            name = "user",
            value = "用户详细实体user",
            required = true,
            dataType = "User",
            paramType = "body"
    )
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseWrapper<Void> postUser(@ModelAttribute User user) {
        userMap.put(user.getId(), user);
        return new ResponseWrapper<>("ok", "success", null);
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(
            name = "id",
            value = "用户ID",
            required = true,
            dataType = "Long",
            paramType = "path",
            defaultValue = "1"
    )
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseWrapper<User> getUser(@PathVariable Long id) {
        return new ResponseWrapper<>("ok", "success", userMap.get(id));
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "id",
                    value = "用户ID",
                    required = true,
                    dataType = "Long",
                    paramType = "path"),
            @ApiImplicitParam(
                    name = "user",
                    value = "用户详细实体user",
                    required = true,
                    dataType = "User",
                    paramType = "body"
            )
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseWrapper<Void> getUser(@PathVariable Long id, @ModelAttribute User user) {
        User exist = userMap.get(id);
        exist.setName(user.getName());
        exist.setAge(user.getAge());
        return new ResponseWrapper<>("ok", "success", null);
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(
            name = "id",
            value = "用户ID",
            required = true,
            dataType = "Long",
            defaultValue = "1",
            paramType = "path"
    )
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseWrapper<Void> deleteUser(@PathVariable Long id) {
        userMap.remove(id);
        return new ResponseWrapper<>("ok", "success", null);
    }


}
