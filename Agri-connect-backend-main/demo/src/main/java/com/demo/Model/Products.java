package com.demo.Model;

public class Products {
	
	private String pid;
	private String ptitle;
	private String pprice;
	private String pimage;
	private Integer qty; 
	
	public Products() {
		super();
	}

	public Products(String pid, String ptitle, String pprice, String pimage,Integer qty) {
		super();
		this.pid = pid;
		this.ptitle = ptitle;
		this.pprice = pprice;
		this.pimage = pimage;
		this.qty=qty;
	}

	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
		this.pprice = pprice;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Products [pid=" + pid + ", ptitle=" + ptitle + ", pprice=" + pprice + ", pimage=" + pimage + ", qty="
				+ qty + "]";
	}
}