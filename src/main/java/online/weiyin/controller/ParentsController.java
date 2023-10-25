package online.weiyin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import online.weiyin.common.Result;
import online.weiyin.common.ResultCode;
import online.weiyin.dto.ParentInfo;
import online.weiyin.entity.Parents;
import online.weiyin.entity.Students;
import online.weiyin.entity.Teachers;
import online.weiyin.service.ParentsService;
import online.weiyin.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  家长管理
 * </p>
 *
 * @author 卢子昂
 * @since 2023-10-14
 */
@RestController
@RequestMapping("/schoollink/parents")
public class ParentsController {
    @Autowired
    ParentsService parentsService;
    @Autowired
    StudentsService studentsService;

    /**
     * 管理功能-查找家长列表
     * @return
     */
    @GetMapping("/getParentsList")
    @SaCheckLogin
    public Result getParentsList() {
        List<Parents> list = parentsService.list();
        return Result.success(list);
    }

    /**
     * 根据id获取家长信息
     * @param id 业务角度唯一性标识
     * @return
     */
    @GetMapping("/getParentByUnique/{id}")
    @SaCheckLogin
    public Result getParentByUnique(@PathVariable String id) {
        QueryWrapper<Parents> wrapper = new QueryWrapper<Parents>()
                .eq("parent_unique_id",id);
        Parents parents = parentsService.getOne(wrapper);
        return Result.success(parents);
    }

    /**
     * 管理功能-查看家长对应的学生信息
     * @return
     */
    @GetMapping("/getStudentList/{id}")
    @SaCheckLogin
    public Result getStudentsByParent(@PathVariable String id) {
        QueryWrapper<Students> wrapper = new QueryWrapper<Students>()
                .eq("parents", id);
        List<Students> list = studentsService.list(wrapper);
        return Result.success(list);
    }

    /**
     * 更新家长的个人信息
     * @param info
     * @return
     */
    @PostMapping("/updateParent")
    @SaCheckLogin
    public Result updateParent(@RequestBody ParentInfo info) {
//        构造查询条件
        QueryWrapper<Parents> wrapper = new QueryWrapper<Parents>()
                .eq("parent_unique_id", StpUtil.getLoginId());
//        构造更新对象
        Parents parents = new Parents();
        parents.setGender(info.getGender());
        parents.setContactPhone(info.getContactPhone());
        parents.setContactEmail(info.getContactEmail());
//        执行更新
        boolean update = parentsService.update(parents, wrapper);
        if(update) {
            return Result.success();
        } else {
            return Result.fail(ResultCode.UPDATE_ERROR1);
        }
    }
}
