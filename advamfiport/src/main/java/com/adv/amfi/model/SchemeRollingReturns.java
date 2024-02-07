package com.adv.amfi.model;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "scheme_rolling_returns")
public class SchemeRollingReturns {

	@Id
	@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@GeneratedValue(generator = "rolling_sequence")
    @GenericGenerator(name = "rolling_sequence",strategy = "increment")
	
	public int id;
	String scheme_company;
	String scheme_category;
	String scheme_amfi_code;
	String scheme_name;
	String period;
	Date nav_date;
	Double scheme_nav;
	Date scheme_forward_date;
	Double scheme_forward_nav;
	Double scheme_rolling_returns;
	String url;
	String scheme_amfi_common;
	String scheme_amfi_short_name;
	String scheme_plan_type;
	String category_short_name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScheme_company() {
		return scheme_company;
	}
	public void setScheme_company(String scheme_company) {
		this.scheme_company = scheme_company;
	}
	public String getScheme_category() {
		return scheme_category;
	}
	public void setScheme_category(String scheme_category) {
		this.scheme_category = scheme_category;
	}
	public String getScheme_name() {
		return scheme_name;
	}
	public void setScheme_name(String scheme_name) {
		this.scheme_name = scheme_name;
	}
	public Date getNav_date() {
		return nav_date;
	}
	public void setNav_date(Date nav_date) {
		this.nav_date = nav_date;
	}
	public Double getScheme_nav() {
		return scheme_nav;
	}
	public void setScheme_nav(Double scheme_nav) {
		this.scheme_nav = scheme_nav;
	}
	public Double getScheme_forward_nav() {
		return scheme_forward_nav;
	}
	public void setScheme_forward_nav(Double scheme_forward_nav) {
		this.scheme_forward_nav = scheme_forward_nav;
	}
	public Double getScheme_rolling_returns() {
		return scheme_rolling_returns;
	}
	public void setScheme_rolling_returns(Double scheme_rolling_returns) {
		this.scheme_rolling_returns = scheme_rolling_returns;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Date getScheme_forward_date() {
		return scheme_forward_date;
	}
	public void setScheme_forward_date(Date scheme_forward_date) {
		this.scheme_forward_date = scheme_forward_date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getScheme_amfi_code() {
		return scheme_amfi_code;
	}
	public void setScheme_amfi_code(String scheme_amfi_code) {
		this.scheme_amfi_code = scheme_amfi_code;
	}
	public String getScheme_amfi_common() {
		return scheme_amfi_common;
	}
	public void setScheme_amfi_common(String scheme_amfi_common) {
		this.scheme_amfi_common = scheme_amfi_common;
	}
	public String getScheme_amfi_short_name() {
		return scheme_amfi_short_name;
	}
	public void setScheme_amfi_short_name(String scheme_amfi_short_name) {
		this.scheme_amfi_short_name = scheme_amfi_short_name;
	}
	public String getScheme_plan_type() {
		return scheme_plan_type;
	}
	public void setScheme_plan_type(String scheme_plan_type) {
		this.scheme_plan_type = scheme_plan_type;
	}
	public String getCategory_short_name() {
		return category_short_name;
	}
	public void setCategory_short_name(String category_short_name) {
		this.category_short_name = category_short_name;
	}	
}
