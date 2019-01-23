package com.hx.dao;/*
 */

import com.hx.pwcontrol.system.SysUserResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface SysUserResumeRepo extends JpaRepository<SysUserResume, String> {
}
