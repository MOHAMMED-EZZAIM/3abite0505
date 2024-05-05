package  ma.zs.univ.ws.converter.taxe38;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.univ.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.univ.zynerator.util.StringUtil;
import ma.zs.univ.zynerator.converter.AbstractConverter;
import ma.zs.univ.zynerator.util.DateUtil;
import ma.zs.univ.bean.core.taxe38.CategorieLocale;
import ma.zs.univ.ws.dto.taxe38.CategorieLocaleDto;

@Component
public class CategorieLocaleConverter {


    public  CategorieLocaleConverter() {
    }


    public CategorieLocale toItem(CategorieLocaleDto dto) {
        if (dto == null) {
            return null;
        } else {
        CategorieLocale item = new CategorieLocale();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public CategorieLocaleDto toDto(CategorieLocale item) {
        if (item == null) {
            return null;
        } else {
            CategorieLocaleDto dto = new CategorieLocaleDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<CategorieLocale> toItem(List<CategorieLocaleDto> dtos) {
        List<CategorieLocale> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (CategorieLocaleDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<CategorieLocaleDto> toDto(List<CategorieLocale> items) {
        List<CategorieLocaleDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (CategorieLocale item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(CategorieLocaleDto dto, CategorieLocale t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<CategorieLocale> copy(List<CategorieLocaleDto> dtos) {
        List<CategorieLocale> result = new ArrayList<>();
        if (dtos != null) {
            for (CategorieLocaleDto dto : dtos) {
                CategorieLocale instance = new CategorieLocale();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
