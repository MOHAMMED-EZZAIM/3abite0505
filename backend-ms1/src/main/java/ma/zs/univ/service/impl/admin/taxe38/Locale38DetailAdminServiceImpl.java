package ma.zs.univ.service.impl.admin.taxe38;


import ma.zs.univ.zynerator.exception.EntityNotFoundException;
import ma.zs.univ.bean.core.taxe38.Locale38Detail;
import ma.zs.univ.dao.criteria.core.taxe38.Locale38DetailCriteria;
import ma.zs.univ.dao.facade.core.taxe38.Locale38DetailDao;
import ma.zs.univ.dao.specification.core.taxe38.Locale38DetailSpecification;
import ma.zs.univ.service.facade.admin.taxe38.Locale38DetailAdminService;
import ma.zs.univ.zynerator.service.AbstractServiceImpl;
import ma.zs.univ.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import ma.zs.univ.zynerator.util.RefelexivityUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.univ.service.facade.admin.taxe38.TypeLocale38DetailAdminService ;
import ma.zs.univ.bean.core.taxe38.TypeLocale38Detail ;

import java.util.List;
@Service
public class Locale38DetailAdminServiceImpl implements Locale38DetailAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Locale38Detail update(Locale38Detail t) {
        Locale38Detail loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{Locale38Detail.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public Locale38Detail findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public Locale38Detail findOrSave(Locale38Detail t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            Locale38Detail result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<Locale38Detail> importData(List<Locale38Detail> items) {
        List<Locale38Detail> list = new ArrayList<>();
        for (Locale38Detail t : items) {
            Locale38Detail founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<Locale38Detail> findAll() {
        return dao.findAll();
    }

    public List<Locale38Detail> findByCriteria(Locale38DetailCriteria criteria) {
        List<Locale38Detail> content = null;
        if (criteria != null) {
            Locale38DetailSpecification mySpecification = constructSpecification(criteria);
            if (criteria.isPeagable()) {
                Pageable pageable = PageRequest.of(0, criteria.getMaxResults());
                content = dao.findAll(mySpecification, pageable).getContent();
            } else {
                content = dao.findAll(mySpecification);
            }
        } else {
            content = dao.findAll();
        }
        return content;

    }


    private Locale38DetailSpecification constructSpecification(Locale38DetailCriteria criteria) {
        Locale38DetailSpecification mySpecification =  (Locale38DetailSpecification) RefelexivityUtil.constructObjectUsingOneParam(Locale38DetailSpecification.class, criteria);
        return mySpecification;
    }

    public List<Locale38Detail> findPaginatedByCriteria(Locale38DetailCriteria criteria, int page, int pageSize, String order, String sortField) {
        Locale38DetailSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(Locale38DetailCriteria criteria) {
        Locale38DetailSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<Locale38Detail> findByTypeLocale38DetailId(Long id){
        return dao.findByTypeLocale38DetailId(id);
    }
    public int deleteByTypeLocale38DetailId(Long id){
        return dao.deleteByTypeLocale38DetailId(id);
    }
    public long countByTypeLocale38DetailCode(String code){
        return dao.countByTypeLocale38DetailCode(code);
    }

	public boolean deleteById(Long id) {
        boolean condition = deleteByIdCheckCondition(id);
        if (condition) {
            dao.deleteById(id);
        }
        return condition;
    }

    public boolean deleteByIdCheckCondition(Long id) {
        return true;
    }

    public void deleteByIdIn(List<Long> ids) {
        //dao.deleteByIdIn(ids);
    }
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int delete(Locale38Detail t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Locale38Detail> delete(List<Locale38Detail> list) {
		List<Locale38Detail> result = new ArrayList();
        if (list != null) {
            for (Locale38Detail t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Locale38Detail create(Locale38Detail t) {
        Locale38Detail loaded = findByReferenceEntity(t);
        Locale38Detail saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Locale38Detail> create(List<Locale38Detail> ts) {
        List<Locale38Detail> result = new ArrayList<>();
        if (ts != null) {
            for (Locale38Detail t : ts) {
				Locale38Detail created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public Locale38Detail findWithAssociatedLists(Long id){
        Locale38Detail result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<Locale38Detail> update(List<Locale38Detail> ts, boolean createIfNotExist) {
        List<Locale38Detail> result = new ArrayList<>();
        if (ts != null) {
            for (Locale38Detail t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    Locale38Detail loadedItem = dao.findById(t.getId()).orElse(null);
                    if (createIfNotExist && (t.getId() == null || loadedItem == null)) {
                        dao.save(t);
                    } else if (t.getId() != null && loadedItem != null) {
                        dao.save(t);
                    } else {
                        result.add(t);
                    }
                }
            }
        }
        return result;
    }





    public Locale38Detail findByReferenceEntity(Locale38Detail t){
        return t==null? null : dao.findByCode(t.getCode());
    }
    public void findOrSaveAssociatedObject(Locale38Detail t){
        if( t != null) {
            t.setTypeLocale38Detail(typeLocale38DetailService.findOrSave(t.getTypeLocale38Detail()));
        }
    }



    public List<Locale38Detail> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<Locale38Detail>> getToBeSavedAndToBeDeleted(List<Locale38Detail> oldList, List<Locale38Detail> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<Locale38Detail> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private TypeLocale38DetailAdminService typeLocale38DetailService ;

    private @Autowired Locale38DetailDao dao;


}
