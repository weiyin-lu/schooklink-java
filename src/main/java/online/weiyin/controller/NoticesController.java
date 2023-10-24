package online.weiyin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import online.weiyin.common.Result;
import online.weiyin.common.ResultCode;
import online.weiyin.dto.NoticeDTO;
import online.weiyin.entity.Notices;
import online.weiyin.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        boolean save = noticesService.save(notices);
        if(save) {
            return Result.success();
        } else {
            return Result.fail(ResultCode.INSERT_ERROR1);
        }

    }
}
