package edu.com.unoesc.restaurante.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import edu.com.unoesc.restaurante.dao.CategoriaDAO;
import edu.com.unoesc.restaurante.models.Categoria;
import edu.com.unoesc.restaurante.models.Comanda;

@FacesConverter(value = "ComandaConverter", forClass = Comanda.class)
public class ComandaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
			Comanda p = (Comanda) component.getAttributes().get(value);
            return p;
        }
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && (value instanceof Comanda)) {
			Comanda p = (Comanda) value; 
			component.getAttributes().put( String.valueOf(p.getId()), p);
            return String.valueOf(p.getId());
        }
		return null;
	}
	
	
}