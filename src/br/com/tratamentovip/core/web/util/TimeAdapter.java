package br.com.tratamentovip.core.web.util;

import java.io.Serializable;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TimeAdapter extends XmlAdapter<java.util.Date, java.sql.Time> implements Serializable{

    private static final long serialVersionUID = -5651795911430472876L;

    @Override
  public java.util.Date marshal(java.sql.Time sqlDate) throws Exception {
      if(null == sqlDate) {
          return null;
      }
      return new java.util.Date(sqlDate.getTime());
  }

  @Override
  public java.sql.Time unmarshal(java.util.Date utilDate) throws Exception {
      if(null == utilDate) {
          return null;
      }
      return new java.sql.Time(utilDate.getTime());
  }
}

