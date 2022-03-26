package model;

import javax.persistence.*;

@Entity
@Table(name="stu")
public class Student {
@Id
private int rno;
@Column
private String sname;
public int getRno() {
	return rno;
}
public void setRno(int rno) {
	this.rno = rno;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}

}
