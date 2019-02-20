package DAL;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import models.Setting;

public class SettingsDAL extends BaseDAL {
	public List<Setting> selectAll() {
		SqlSession session = getSqlSessionFactory().openSession();
		List<Setting> ret = session.selectList("setting.selectAll");
		session.close();
		return ret;
	}
	
	public Setting selectById(int id) {
		SqlSession session = getSqlSessionFactory().openSession();
		Setting ret = session.selectOne("setting.selectById", id);
		session.close();
		return ret;
	}
	
	public int insert(Setting setting) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.insert("setting.insertSetting", setting);
		session.close();
		return ret;
	}
	
	public int update(Setting setting) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.update("setting.updateSetting", setting);
		session.close();
		return ret;
	}
	
	public int delete(int id) {
		SqlSession session = getSqlSessionFactory().openSession(true);
		int ret = session.delete("setting.deleteSetting", id);
		session.close();
		return ret;
	}
}
