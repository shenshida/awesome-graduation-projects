package com.bjsxt.entity;

import java.util.Date;

/**
 * 借入
 * 
 * @author Administrator
 */
public class Borrow {
	private int id;
	private int bid;
	private int rid;
	private int sid;
	private Date borrowTime;
	private Date backTime;
	private int ifback;
	private BookBaseInfo bookBaseInfo;
	private Reader reader;

	private int days;
	private String sex;
	private String paperType;
	private String paperNo;
	private String name;
	private String rname;
	private String bname;
	private int number;
	private String isbn;
	private int bcid;
	private Publishing publishing;
	private BookCase bookCase;
	private double price;

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Borrow(int id, int bid, int rid, int sid, Date borrowTime,
			Date backTime, int ifback, String sex, String paperType,
			String paperNo, String name, String rname, String bname,
			int number, String isbn, int bcid, Publishing publishing,
			BookCase bookCase, double price) {
		super();
		this.id = id;
		this.bid = bid;
		this.rid = rid;
		this.sid = sid;
		this.borrowTime = borrowTime;
		this.backTime = backTime;
		this.ifback = ifback;
		this.sex = sex;
		this.paperType = paperType;
		this.paperNo = paperNo;
		this.name = name;
		this.rname = rname;
		this.bname = bname;
		this.number = number;
		this.isbn = isbn;
		this.bcid = bcid;
		this.publishing = publishing;
		this.bookCase = bookCase;
		this.price = price;
	}

	public Borrow(int id, int bid, int rid, int sid, Date borrowTime,
			Date backTime, int ifback, String sex, String paperType,
			String paperNo, String name, String rname, int number, String isbn,
			int bcid, Publishing publishing, BookCase bookCase, double price) {
		super();
		this.id = id;
		this.bid = bid;
		this.rid = rid;
		this.sid = sid;
		this.borrowTime = borrowTime;
		this.backTime = backTime;
		this.ifback = ifback;
		this.sex = sex;
		this.paperType = paperType;
		this.paperNo = paperNo;
		this.name = name;
		this.rname = rname;
		this.number = number;
		this.isbn = isbn;
		this.bcid = bcid;
		this.publishing = publishing;
		this.bookCase = bookCase;
		this.price = price;
	}

	public Borrow(Date borrowTime, Date backTime) {
		super();
		this.borrowTime = borrowTime;
		this.backTime = backTime;
	}

	public Borrow() {
		super();
	}
    
	public Borrow(int bid, int rid, int sid, Date borrowTime, Date backTime,
			int ifback) {
		super();
		this.bid = bid;
		this.rid = rid;
		this.sid = sid;
		this.borrowTime = borrowTime;
		this.backTime = backTime;
		this.ifback = ifback;
	}

	public Borrow(int bid, int rid, Date borrowTime, Date backTime, int ifback,
			BookBaseInfo bookBaseInfo, Reader reader) {
		super();
		this.bid = bid;
		this.rid = rid;
		this.borrowTime = borrowTime;
		this.backTime = backTime;
		this.ifback = ifback;
		this.bookBaseInfo = bookBaseInfo;
		this.reader = reader;
	}

	public BookBaseInfo getBookBaseInfo() {
		return bookBaseInfo;
	}

	public void setBookBaseInfo(BookBaseInfo bookBaseInfo) {
		this.bookBaseInfo = bookBaseInfo;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public Date getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}

	public Date getBackTime() {
		return backTime;
	}

	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	public int getIfback() {
		return ifback;
	}

	public void setIfback(int ifback) {
		this.ifback = ifback;
	}

	public String getSex() {
		return sex;
	}

	@Override
	public String toString() {
		return "Borrow [id=" + id + ", bid=" + bid + ", rid=" + rid + ", sid="
				+ sid + ", borrowTime=" + borrowTime + ", backTime=" + backTime
				+ ", ifback=" + ifback + ", bookBaseInfo=" + bookBaseInfo
				+ ", reader=" + reader + "]";

	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((backTime == null) ? 0 : backTime.hashCode());
		result = prime * result + bid;
		result = prime * result
				+ ((borrowTime == null) ? 0 : borrowTime.hashCode());
		result = prime * result + id;
		result = prime * result + ifback;
		result = prime * result + rid;
		result = prime * result + sid;
		return result;

	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public String getPaperNo() {
		return paperNo;
	}

	public void setPaperNo(String paperNo) {
		this.paperNo = paperNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getBcid() {
		return bcid;
	}

	public void setBcid(int bcid) {
		this.bcid = bcid;
	}

	public Publishing getPublishing() {
		return publishing;
	}

	public void setPublishing(Publishing publishing) {
		this.publishing = publishing;
	}

	public BookCase getBookCase() {
		return bookCase;
	}

	public void setBookCase(BookCase bookCase) {
		this.bookCase = bookCase;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Borrow(int bid, int rid, Date borrowTime, Date backTime, int ifback) {
		super();
		this.bid = bid;
		this.rid = rid;
		this.borrowTime = borrowTime;
		this.backTime = backTime;
		this.ifback = ifback;
	}

	public Borrow(int id, int bid, int rid, int sid, Date borrowTime,
			Date backTime, int ifback, int days, String sex, String paperType,
			String paperNo, String name, String rname, String bname,
			int number, String isbn, int bcid, Publishing publishing,
			BookCase bookCase, double price) {
		super();
		this.id = id;
		this.bid = bid;
		this.rid = rid;
		this.sid = sid;
		this.borrowTime = borrowTime;
		this.backTime = backTime;
		this.ifback = ifback;
		this.days = days;
		this.sex = sex;
		this.paperType = paperType;
		this.paperNo = paperNo;
		this.name = name;
		this.rname = rname;
		this.bname = bname;
		this.number = number;
		this.isbn = isbn;
		this.bcid = bcid;
		this.publishing = publishing;
		this.bookCase = bookCase;
		this.price = price;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Borrow other = (Borrow) obj;
		if (backTime == null) {
			if (other.backTime != null)
				return false;
		} else if (!backTime.equals(other.backTime))
			return false;
		if (bid != other.bid)
			return false;
		if (borrowTime == null) {
			if (other.borrowTime != null)
				return false;
		} else if (!borrowTime.equals(other.borrowTime))
			return false;
		if (id != other.id)
			return false;
		if (ifback != other.ifback)
			return false;
		if (rid != other.rid)
			return false;
		if (sid != other.sid)
			return false;
		return true;
	}
}
