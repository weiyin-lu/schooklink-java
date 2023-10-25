package online.weiyin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
@RequestMapping("/weiyin/notices")
public class NoticesController {
    @Autowired
    NoticesService noticesService;

    /**
     * 添加新通知（受全局异常拦截控制）
     * @param noticeDTO
     * @return
     */
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
            return Result.success();
        } else {
            return Result.fail(ResultCode.INSERT_ERROR1);
        }
    }

    /**
     * 根据创建者查询通知列表
     * @return
     */
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
    @GetMapping("/showNoticeListByCondition/{condition}")
    @SaCheckLogin
    public Result showNoticeListByCondition(@PathVariable String condition) {
        QueryWrapper<Notices> wrapper = new QueryWrapper<Notices>()
                .eq("notice_target", condition);
        List<Notices> list = noticesService.list(wrapper);
        return Result.success(list);
    }

    /**
     * 根据视图id修改当前用户的视图
     * @param id
     * @return
     */
    @GetMapping("/updateNoticeById/{id}")
    @SaCheckLogin
    public Result updateNoticeById(@PathVariable Integer id) {
        return Result.fail(ResultCode.NOT_FOUND);
    }


}
