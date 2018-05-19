package controllers;

import java.util.List;

import DAL.SettingsDAL;
import models.Setting;

public class SettingsController {
	private SettingsDAL dal;
	
	public SettingsController() {
		this.dal = new SettingsDAL();
		dal.initSqlSessionFactory();
	}
	
	public List<Setting> selectAll() {
		return dal.selectAll();
	}
	
	public Setting selectLast() {
		List<Setting> settings = dal.selectAll();
		if (settings.isEmpty()) {
			return null;
		}
		return settings.get(settings.size() - 1);
	}
	
	public Setting selectById(int id) {
		return dal.selectById(id);
	}
	
	public Setting insert(Setting setting) {
		dal.insert(setting);
		return setting;
	}
	
	public Setting upsert(Setting setting) {
		Setting prevSetting = this.selectLast();
		if (prevSetting != null) {
			setting.setId(prevSetting.getId());
			dal.update(setting);
		} else {
			dal.insert(setting);
		}
		return setting;
	}
	
	public int update(Setting setting) {
		return dal.update(setting);
	}
	
	public int delete(int id) {
		return dal.delete(id);
	}
}
