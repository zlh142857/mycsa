package com.hx.dao;/*
 */

import com.hx.system.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {
    @Query(value = "SELECT notice_id,notice_name,notice_auth FROM notice ORDER BY notice_type DESC,create_time DESC LIMIT 5",nativeQuery = true)
    List<Notice> find();
    @Query(value = "DELETE FROM notice WHERE notice_id=:noticeId",nativeQuery = true)
    Integer deleteNoticeById(@Param( "noticeId" ) Integer noticeId);
}
