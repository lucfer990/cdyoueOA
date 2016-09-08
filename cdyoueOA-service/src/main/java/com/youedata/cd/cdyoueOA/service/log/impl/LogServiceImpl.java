package com.youedata.cd.cdyoueOA.service.log.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youedata.cd.cdyoueOA.dao.log.LogDao;
import com.youedata.cd.cdyoueOA.pojo.Log;
import com.youedata.cd.cdyoueOA.service.log.LogService;

@Service
public class LogServiceImpl implements LogService{
    @Autowired
    private LogDao logDao;

	@Override
	public void add(Log log) {
		logDao.add(log);
	}

	@Override
	public void delete(Long id) {
		logDao.delete(id);
	}

	@Override
	public void update(Log log) {
		logDao.update(log);
	}

	@Override
	public Log get(Long id) {
		return logDao.get(id);
	}

	@Override
	public List<Log> getAll(Log log) {
		return logDao.getAll(log);
	}

	@Override
	public List<Log> getDateQuery(Log log) {
		return logDao.getDateQuery(log);
	}

	@Override
	public List<Log> getLogFocus(Log log) {
		return logDao.getLogFocus(log);
	}

    @Override
    public Map findByItem(Log log, int offset, int limit, String order,String startTimeString) {
        List<Log> list=null;
        Map resultMap=new HashMap();
        Map paramMap=new HashMap();
        paramMap.put("star",offset);
        paramMap.put("rows",limit);
        paramMap.put("startTimeString",startTimeString);
        
        try {
            if(log.getStartTime()!=null){
                paramMap.put("fromdate",log.getStartTime());
            }
            if(log.getEndTime()!=null){
                paramMap.put("todate",log.getEndTime());
            }
            paramMap.put("title",log.getTitle());
            paramMap.put("focusUsers",log.getFocusUsers());
            list=logDao.findByItem(paramMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("total",logDao.findByItemCount(paramMap));
        resultMap.put("rows",list);
        return resultMap;
    }

	@Override
	public void delLog(Long id) {
		logDao.delLog(id);
		
	}
}
