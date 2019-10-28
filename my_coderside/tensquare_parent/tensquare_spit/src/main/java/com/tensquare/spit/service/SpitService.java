package com.tensquare.spit.service;

import com.tensquare.common.util.SnowflakeIdWorker;
import com.tensquare.spit.dao.SpitDao;
import com.tensquare.spit.pojo.entity.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author root
 */
@Service
@Transactional
public class SpitService {

    @Autowired
    private SpitDao dao;

    @Autowired
    private SnowflakeIdWorker idCreater;

    @Autowired
    private MongoTemplate mongoTemplate;


    public List<Spit> findAll() {
        return dao.findAll();
    }

    public Spit findById(String id) {
        return dao.findById(id).get();
    }

    public void save(Spit spit) {
        spit.set_id(idCreater.nextId() + "");
        spit.setPublishtime(new Date());
        spit.setVisits(0);
        spit.setShare(0);
        spit.setThumbup(0);
        //评论数（回复数）
        spit.setComment(0);
        spit.setState("1");
        // 如果当前的吐槽有父节点，那么父节点加一(回复数）
        if (spit.getParentid() != null && !"".equals(spit.getParentid())) {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment", 1);
            mongoTemplate.updateFirst(query, update, "spit");
        }
        dao.save(spit);
    }

    public void update(Spit spit) {
        dao.save(spit);
    }

    public void deleteById(String id) {
        dao.deleteById(id);
    }

    public Page<Spit> findByParentid(String parentid, int page, int size){

        Pageable pageable = PageRequest.of(page-1, size);
        return dao.findByParentid(parentid,pageable);
    }

    public void thumbup(String spitId){
        Spit spit = dao.findById(spitId).get();

        spit.setThumbup(spit.getThumbup() == null ? 0:spit.getThumbup()+1);
        dao.save(spit);
    }

}
