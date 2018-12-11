package com.hx.dao;/*
 */

import com.hx.Activiti.ActMsgPersonnel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public interface ActivitiRepository extends CrudRepository<ActMsgPersonnel, Integer> {
    @Query(value="UPDATE act_msg_personnel SET status=1 WHERE uid=:userid AND pro_id=:pid AND over_time=:date",nativeQuery = true)
    int updateStatusByPid(@Param( "pid" ) String pid, @Param( "userid" )Integer userid,@Param( "date" ) Date date);
    @Query(value="SELECT type,pro_id,create_time FROM act_msg_personnel where uid=:uid and status=0",nativeQuery = true)
    List<ActMsgPersonnel> findRunningTask(@Param( "uid" )Integer uid);
    @Query(value="SELECT type,pro_id,create_time FROM act_msg_personnel where uid=:uid and status=1",nativeQuery = true)
    List<ActMsgPersonnel> findRunnedTask(@Param( "uid" )Integer uid);
}
