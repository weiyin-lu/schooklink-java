package online.weiyin.service.impl;

import online.weiyin.entity.Students;
import online.weiyin.mapper.StudentsMapper;
import online.weiyin.service.StudentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 卢子昂
 * @since 2023-10-14
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements StudentsService {

}
