package com.hyr.youling.usercenter.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author hyr
 * @date 19-11-14-下午10:34
 * @description
 * */
@RestController
@RequestMapping("/user")
public class UserController
{

    @ApiOperation(value = "检查用户是否存在")
    @RequestMapping(value = "/check/{nickname}",method = RequestMethod.GET)
    public Object checkNickName(@PathVariable(value = "nickname") String nickname){
        return nickname;
    }
}
