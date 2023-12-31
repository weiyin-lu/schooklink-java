package online.weiyin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import online.weiyin.common.Result;
import online.weiyin.common.ResultCode;
import online.weiyin.dto.LoginDTO;
import online.weiyin.dto.RegisterDTO;
import online.weiyin.entity.Parents;
import online.weiyin.entity.Students;
import online.weiyin.entity.Teachers;
import online.weiyin.entity.Users;
import online.weiyin.service.ParentsService;
import online.weiyin.service.StudentsService;
import online.weiyin.service.TeachersService;
import online.weiyin.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  用户认证和鉴权
 * </p>
 *
 * @author 卢子昂
 * @since 2023-10-14
 */
@RestController
@SaCheckLogin
@RequestMapping("/schoollink/users")
public class UsersController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private TeachersService teachersService;
    @Autowired
    private StudentsService studentsService;
    @Autowired
    private ParentsService parentsService;

    /**
     * 用户登录
     * @param loginDTO 账号密码，包含username和password
     * @return 当前用户的token，该值也会被框架自动注入到Cookie中（仅登录成功）
     */
    @ApiOperation("用户登录")
    @SaIgnore
    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO loginDTO) {
        QueryWrapper<Users> wrapper = new QueryWrapper<Users>()
                .eq("username",loginDTO.getUsername())
                .eq("password",loginDTO.getPassword());
            Users one = usersService.getOne(wrapper);
//            如果能查询到一条记录，说明登录成功；数据库中包含唯一约束，不可能插入不唯一的username
            if(one != null) {
//                框架提供的登录，自动生成token
                StpUtil.login(loginDTO.getUsername());
                return Result.success("登录成功",StpUtil.getTokenInfo());
            }
            else {
                return Result.fail(ResultCode.CHECK_ERROR1);
            }
    }

    /**
     * 注册方法
     * @param registerDTO 注册dto
     * @return 注册成功或失败信息（受全局异常拦截控制）
     */
    @ApiOperation("注册")
    @PostMapping("/register")
    @Transactional
    public Result register(@RequestBody RegisterDTO registerDTO) {
//        构造users对象
        Users users = new Users();
        users.setUserType(registerDTO.getUserType());
        users.setPassword(registerDTO.getPassword());
        users.setUsername(registerDTO.getUsername());
//        检查userType是否为空（避免switch参数空指针）
        if(registerDTO.getUserType() == null) {
            return Result.fail(ResultCode.INSERT_ERROR2);
        }
//        根据角色类型访问不同数据表插入
        switch(registerDTO.getUserType()) {
            case "1":
                Teachers teachers = new Teachers();
                teachers.setUniqueId(registerDTO.getUsername());
                teachers.setName(registerDTO.getName());
                teachers.setContactPhone(registerDTO.getPhone());
//                默认值，参考码表
                teachers.setGender("3");
                teachers.setGrade("000000");

                usersService.save(users);
                teachersService.save(teachers);
                break;
            case "2":
                Parents parents = new Parents();
                parents.setUniqueId(registerDTO.getUsername());
                parents.setName(registerDTO.getName());
                parents.setContactPhone(registerDTO.getPhone());
//                默认值，参考码表
                parents.setGender("3");

                usersService.save(users);
                parentsService.save(parents);
                break;
            case "3":
                Students students = new Students();
                students.setUniqueId(registerDTO.getUsername());
                students.setName(registerDTO.getName());
//                默认值，参考码表
                students.setGender("3");
                students.setGrade("000000");

                usersService.save(users);
                studentsService.save(students);
                break;
            default:
                return Result.fail(ResultCode.CHECK_ERROR4);
        }
        return Result.success("注册成功");

    }

    /**
     * 根据角色获得当前用户的信息
     * @return 用户信息（受全局异常拦截控制）
     */
    @ApiOperation("根据角色获得当前用户的信息")
    @GetMapping("/getInfo")
    public Result getInfo() {
//        通过登录信息获得角色身份，必须在登录后才能操作，可以规避列表为空的问题
        List<String> roleList = StpUtil.getRoleList();
        String s = roleList.get(0);
//        根据角色标签构造不同表的查询条件，调用不同查询，并返回信息
            switch (s) {
                case "1" :
                    QueryWrapper<Teachers> wrapper1 = new QueryWrapper<Teachers>()
                            .eq("teacher_unique_id",StpUtil.getLoginId());
                    return Result.success(teachersService.getOne(wrapper1));
                case "2" :
                    QueryWrapper<Parents> wrapper2 = new QueryWrapper<Parents>()
                            .eq("parent_unique_id",StpUtil.getLoginId());
                    return Result.success(parentsService.getOne(wrapper2));
                case "3" :
                    QueryWrapper<Students> wrapper3 = new QueryWrapper<Students>()
                            .eq("student_unique_id",StpUtil.getLoginId());
                    return Result.success(studentsService.getOne(wrapper3));
                case "admin": // 固定系统管理员信息
                    HashMap<String, String> map = new HashMap<>();
                    map.put("uniqueId","admin");
                    map.put("name","系统管理员");
                    return Result.success(map);
                default: return Result.fail(ResultCode.CHECK_ERROR2);
            }
    }

    @ApiOperation("获取当前角色身份id")
    @GetMapping("/getRole")
    public Result getRole() {
        List<String> roleList = StpUtil.getRoleList();
        return Result.success(roleList);
    }

    /**
     * 登出
     * @return
     */
    @ApiOperation("登出")
    @SaIgnore
    @GetMapping("/logout")
    public Result logout() {
        StpUtil.logout();
        return Result.success("注销成功");
    }

    /**
     * 检查登录状态
     * @return
     */
    @ApiOperation("检查登录状态")
    @SaIgnore
    @GetMapping("/isLogin")
    public Result isLogin() {
        if(StpUtil.isLogin()) {
            return Result.success("登录状态正常");
        }
        else {
            return Result.fail(ResultCode.CHECK_ERROR2);
        }
    }
}
