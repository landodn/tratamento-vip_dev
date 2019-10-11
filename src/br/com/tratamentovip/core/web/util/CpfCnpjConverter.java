package br.com.tratamentovip.core.web.util;

import java.text.ParseException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.swing.text.MaskFormatter;

@FacesConverter("cpfCnpjConverter")
public class CpfCnpjConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent ui, String arg){
		String value = "";
		MaskFormatter mask;
		try{
			if(arg.length() > 11){
				mask = new MaskFormatter("###.###.###-##");
			}else{
				mask = new MaskFormatter("###.###.###/####-##");
			}
			mask.setValueContainsLiteralCharacters(false);
			value = mask.valueToString(arg);
		}catch(ParseException ex){
		}
		return value;
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent ui, Object obj){
		return obj.toString();
	}
}
