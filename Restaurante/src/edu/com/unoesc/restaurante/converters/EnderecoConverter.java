package edu.com.unoesc.restaurante.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import edu.com.unoesc.restaurante.models.Endereco;

@FacesConverter(value = "EnderecoConverter", forClass = Endereco.class)
public class EnderecoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
			Endereco p = (Endereco) component.getAttributes().get(value);
            return p;
        }
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && (value instanceof Endereco)) {
			Endereco p = (Endereco) value; 
			component.getAttributes().put( String.valueOf(p.getId()), p);
            return String.valueOf(p.getId());
        }
		return null;
	}
	
	
}