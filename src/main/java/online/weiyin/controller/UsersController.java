package online.weiyin.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import online.weiyin.common.Result;
import online.weiyin.common.ResultCode;
import online.weiyin.dto.LoginDTO;
import online.weiyin.entity.Users;
import online.weiyin.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  控制器-用户认证相关
 * </p>
 *
 * @author 卢子昂
 * @since 2023-10-14
 */
@RestController
@RequestMapping("/schoollink/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 用户登录
     * @param loginDTO 账号密码，包含username和password
     * @return 当前用户的token，该值也会被框架自动注入到Cookie中（仅登录成功）
     */
    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody LoginDTO loginDTO) {
        QueryWrapper<Users> wrapper = new QueryWrapper<Users>()
                .eq("username",loginDTO.getUsername())
                .eq("password",loginDTO.getPassword());
            Users one = usersService.getOne(wrapper);
//            如果能查询到一条记录，说明登录成功；数据库中包含唯一约束，不可能插入不唯一的username
            if(one != null) {
//                框架提供的登录，自动生成token
                StpUtil.login(loginDTO.getUsername());
                return Result.success(StpUtil.getTokenValue());
            }
            else {
                return Result.fail(ResultCode.LOGIN_FAIL);
            }
    }

    /**
     * 登出
     * @return
     */
    @GetMapping("/logout")
    @ResponseBody
    public Result logout() {
        StpUtil.logout();
        return Result.success();
    }

    /**
     * 检查登录状态
     * @return
     */
    @GetMapping("/isLogin")
    @ResponseBody
    public Result isLogin() {
        if(StpUtil.isLogin()) {
            return Result.success();
        }
        else {
            return Result.fail(ResultCode.LOGIN_OUT);
        }
    }

}
