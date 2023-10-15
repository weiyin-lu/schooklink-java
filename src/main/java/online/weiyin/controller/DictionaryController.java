package online.weiyin.controller;

import cn.hutool.json.JSONUtil;
import online.weiyin.common.Result;
import online.weiyin.entity.Dictionary;
import online.weiyin.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 卢子昂
 * @since 2023-10-14
 */
@RestController
@RequestMapping("/schoollink/dictionary")
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("/hello")
    @ResponseBody
    public Result hello() {
        List<Dictionary> list = dictionaryService.list();
        return Result.success(list);
    }
}
