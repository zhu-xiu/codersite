package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import com.tensquare.common.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author root
 */

@Service
@Transactional
public class LabelSercice {

    @Autowired
    private LabelDao labelDao;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<Label> findAll(){
        return labelDao.findAll();
    }

    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    public void save(Label label){
        label.setId(snowflakeIdWorker.nextId() +"");
        labelDao.save(label);
    }

    public void update(Label label){
        labelDao.save(label);
    }

    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    /**
     * 条件查询
     * @param label
     * @return
     */
    public List<Label> findSearch(Label label){
      return labelDao.findAll(new Specification<Label>() {
          /**
           *
           * @param root 跟对象，也就是要把条件封装到哪个对象中。where 类名 = label.getid;
           * @param criteriaQuery 封装的都是查询关键字，比如group by,order by....
           * @param cb 用来封装条件对象，如果直接返回null，表示不需要任何条件。
           * @return
           */
           @Override
           public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
               // 用来存放所有Predicate1条件
               List<Predicate> list = new ArrayList<>();
               if(label.getLabelname() != null &&
                       !"".equals(label.getLabelname())){
                   // 转换成sql语句。 where labelname = "小明"
                  Predicate predicate = cb.like(root.get("labelname").as(String.class),
                           "%" +label.getLabelname() + "%");
                  list.add(predicate);
               }

               if(label.getState() != null &&
                       !"".equals(label.getState())){
                   // 转换成sql语句。 where state = "1"
                   Predicate predicate = cb.equal(root.get("state").as(String.class),
                            label.getState()  );
                   list.add(predicate);
               }

               //new 一个数组作为最终返回值的条件
               Predicate[] parr = new Predicate[list.size()];
               // 把list 转为数组
               parr = list.toArray(parr);
               return cb.and(parr);
           }
       });
    }

    /**
     * 分页条件查询
     * @param label
     * @param page
     * @param size
     * @return
     */
    public Page<Label> pageQuery(Label label, int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             *
             * @param root 跟对象，也就是要把条件封装到哪个对象中。where 类名 = label.getid;
             * @param criteriaQuery 封装的都是查询关键字，比如group by,order by....
             * @param cb 用来封装条件对象，如果直接返回null，表示不需要任何条件。
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                // 用来存放所有Predicate1条件
                List<Predicate> list = new ArrayList<>();
                if(label.getLabelname() != null &&
                        !"".equals(label.getLabelname())){
                    // 转换成sql语句。 where labelname = "小明"
                    Predicate predicate = cb.like(root.get("labelname").as(String.class),
                            "%" +label.getLabelname() + "%");
                    list.add(predicate);
                }

                if(label.getState() != null &&
                        !"".equals(label.getState())){
                    // 转换成sql语句。 where state = "1"
                    Predicate predicate = cb.equal(root.get("state").as(String.class),
                            label.getState()  );
                    list.add(predicate);
                }

                //new 一个数组作为最终返回值的条件
                Predicate[] parr = new Predicate[list.size()];
                // 把list 转为数组
                parr = list.toArray(parr);
                return cb.and(parr);
            }
        }, pageable );
    }
}
