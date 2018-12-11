package com.hx.dao;/*
 */

import com.hx.Activiti.ActMsgPersonnel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ActivitiRepository extends CrudRepository<ActMsgPersonnel, Integer> {
}
