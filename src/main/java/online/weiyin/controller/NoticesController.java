package online.weiyin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import online.weiyin.common.Result;
import online.weiyin.common.ResultCode;
import online.weiyin.dto.NoticeDTO;
import online.weiyin.entity.Notices;
import online.weiyin.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  通知业务操作
 * </p>
 *
 * @author 卢子昂
 * @since 2023-10-24
 */
@RestController
@RequestMapping("/schoollink/notices")
public class NoticesController {
    @Autowired
    NoticesService noticesService;

    /**
     * 添加新通知（受全局异常拦截控制）
     * @param noticeDTO
     * @return
     */
    @ApiOperation("添加新通知")
    @PostMapping("/createNotice")
    @SaCheckLogin
    public Result createNotice(@RequestBody NoticeDTO noticeDTO) {
//        构造对象
        Notices notices = new Notices();
        notices.setCreatedId((String) StpUtil.getLoginId());
        notices.setNoticeType(noticeDTO.getNoticeType());
        notices.setNoticeTarget(noticeDTO.getNoticeTarget());
        notices.setInformation(noticeDTO.getInformation());
//        执行插入
        boolean save = noticesService.save(notices);
        if(save) {
            return Result.success("通知添加成功");
        } else {
            return Result.fail(ResultCode.INSERT_ERROR1);
        }
    }

    /**
     * 根据创建者查询通知列表
     * @return
     */
    @ApiOperation("根据创建者查询通知列表")
    @GetMapping("/showNoticeListByCreator")
    @SaCheckLogin
    public Result showNoticeListByCreator() {
        QueryWrapper<Notices> wrapper = new QueryWrapper<Notices>()
                .eq("created_id", StpUtil.getLoginId());
        List<Notices> list = noticesService.list(wrapper);
        return Result.success(list);
    }

    /**
     * 根据指定条件查询通知列表（业务角度唯一性id、班级）
     * @param condition
     * @return
     */
    @ApiOperation("根据指定条件查询通知列表（业务角度唯一性id、班级）")
    @GetMapping("/showNoticeListByCondition/{condition}")
    @SaCheckLogin
    public Result showNoticeListByCondition(@PathVariable String condition) {
        QueryWrapper<Notices> wrapper = new QueryWrapper<Notices>()
                .eq("notice_target", condition);
        List<Notices> list = noticesService.list(wrapper);
        return Result.success(list);
    }

}
