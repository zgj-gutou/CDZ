package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aos.framework.core.id.AOSId;
import aos.framework.core.utils.AOSUtils;
import aos.framework.core.service.CDZBaseController;
import aos.framework.core.typewrap.Dto;
import aos.framework.core.utils.AOSJson;
import aos.framework.web.router.HttpModel;
import aos.system.common.utils.SystemCons;
import dao.ZhuDao;
import po.ZhuPO;

/**
 * charging_pile管理
 * 
 * @author duanchongfeng
 * @date 2017-07-06 20:31:43
 *
 */
@Service
public class ZhuController extends CDZBaseController {

	@Autowired
	private ZhuDao zhuDao;

	/**
	 * charging_pile管理页面初始化
	 * 
	 * @param httpModel
	 * @return
	 */
	public void init(HttpModel httpModel) {
		httpModel.setViewPath("myproject/zhu.jsp");
	}

	/**
	 * 查询charging_pile列表
	 * 
	 * @param httpModel
	 * @return
	 */
	public void listZhu(HttpModel httpModel) {
		Dto qDto = httpModel.getInDto();
		List<Dto> zhuDtos = sqlDao.list("Zhu.listZhusPage", qDto);
		httpModel.setOutMsg(AOSJson.toGridJson(zhuDtos, qDto.getPageTotal()));
	}
	/**
	 * 查询charging_pile信息
	 * 
	 * @param httpModel
	 */
	public void getZhu(HttpModel httpModel) {
		Dto inDto = httpModel.getInDto();
	     ZhuPO zhuPO = zhuDao.selectByKey(inDto.getString("cp_id")); 
		httpModel.setOutMsg(AOSJson.toJson(zhuPO));
	}

	/**
	 * 保存charging_pile
	 * 
	 * @param httpModel
	 * @return
	 */
	 @Transactional
	public void saveZhu(HttpModel httpModel) {
		Dto inDto = httpModel.getInDto();
		ZhuPO zhuPO = new ZhuPO();
		zhuPO.copyProperties(inDto);
		//zhuPO.setCp_id(AOSId.appId(SystemCons.ID.SYSTEM));
		//zhuPO.setCreate_date(AOSUtils.getDateTime());
		zhuDao.insert(zhuPO);
		httpModel.setOutMsg("新增成功。");
	}

	/**
	 * 修改charging_pile
	 * 
	 * @param httpModel
	 * @return
	 */
	 @Transactional
	public void updateZhu(HttpModel httpModel) {
		Dto inDto = httpModel.getInDto();
		ZhuPO zhuPO = new ZhuPO();
		zhuPO.copyProperties(inDto);
		zhuDao.updateByKey(zhuPO);
		httpModel.setOutMsg("修改成功。");
	}

	/**
	 * 删除charging_pile
	 * 
	 * @param httpModel
	 */
	@Transactional
	public void deleteZhu(HttpModel httpModel) {
		String[] selectionIds = httpModel.getInDto().getRows();
		if(null!=selectionIds&&selectionIds.length>0){
			for (String id_ : selectionIds) {
				/*ZhuPO zhuPO = new ZhuPO();
				zhuPO.setCp_id(id_);
				zhuPO.setIs_del(SystemCons.IS.YES);
	            zhuDao.updateByKey(zhuPO);*/ 
	            zhuDao.deleteByKey(id_);
			}
		}else{
				String cp_id=httpModel.getInDto().getString("cp_id");
				/*ZhuPO zhuPO = new ZhuPO();
				zhuPO.setCp_id(cp_id);
				zhuPO.setIs_del(SystemCons.IS.YES);
	            zhuDao.updateByKey(zhuPO); */
			     zhuDao.deleteByKey(cp_id);
			
		}
		httpModel.setOutMsg("删除成功。");
	}

	

}
