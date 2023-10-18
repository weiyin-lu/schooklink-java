package online.weiyin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import online.weiyin.common.Result;
import online.weiyin.common.ResultCode;
import online.weiyin.dto.CodeDTO;
import online.weiyin.entity.Dictionary;
import online.weiyin.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    /**
     * 获取特定编码下的码表键值
     * @return key-value键值对列表
     */
    @GetMapping("/getCode/{dicType}")
    @SaCheckLogin
    public Result getCode(@PathVariable("dicType") String dicType) {
        QueryWrapper<Dictionary> wrapper = new QueryWrapper<Dictionary>()
                .eq("dic_type",dicType);
        List<Dictionary> list = dictionaryService.list(wrapper);
//        抽取键值对
        HashMap<String, String> map = new HashMap<>();
        for(Dictionary dicTemp : list) {
            map.put(dicTemp.getDicKey(), dicTemp.getDicValue());
        }
        return Result.success(map);
    }

    /**
     * 向特定码表插入新值（shou）
     * @param codeDTO 码表type、key、value
     * @return 成功或失败信息（受全局异常拦截控制）
     */
    @PostMapping("/addCode")
    @SaCheckLogin
    public Result addCode(@RequestBody CodeDTO codeDTO) {
//        构造实体类
        Dictionary dictionary = new Dictionary();
        dictionary.setDicKey(codeDTO.getKey());
        dictionary.setDicType(codeDTO.getType());
        dictionary.setDicValue(codeDTO.getValue());
//        执行插入
        boolean save = dictionaryService.save(dictionary);
        if(save) {
            return Result.success();
        } else {
            return Result.fail(ResultCode.INSERT_ERROR1);
        }
    }

    /**
     * 更新码表，更新条件为type和key
     * @param codeDTO
     * @return
     */
    @PostMapping("/updateCode")
    @SaCheckLogin
    public Result UpdateCode(@RequestBody CodeDTO codeDTO) {
//        构造查询条件
        QueryWrapper<Dictionary> wrapper = new QueryWrapper<Dictionary>()
                .eq("dic_type",codeDTO.getType())
                .eq("dic_key", codeDTO.getKey());
//        构造实体类
        Dictionary dictionary = new Dictionary();
        dictionary.setDicType(codeDTO.getType());
        dictionary.setDicValue(codeDTO.getValue());
        dictionary.setDicKey(codeDTO.getKey());
//        执行插入，检查插入结果
        boolean update = dictionaryService.update(dictionary, wrapper);
        if(update) {
            return Result.success();
        } else {
            return Result.fail(ResultCode.UPDATE_ERROR1);
        }
    }
}
