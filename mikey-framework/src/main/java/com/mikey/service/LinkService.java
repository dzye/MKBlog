package com.mikey.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mikey.domain.ResponseResult;
import com.mikey.domain.entity.Link;
import com.mikey.domain.vo.LinkVo;

/**
 * 友链(Link)表服务接口
 *
 * @author mikey
 * @since 2024-02-19 10:02:49
 */
public interface LinkService extends IService<Link> {
     ResponseResult<LinkVo[]> getAllLink();
}
