package com.javaex.projectMySQL;

public class ManagerVo {

	// 필드
	private int memberId;
	private String id;
	private String name;
	private String hp;
	private String birth;
	private String hireDate;
	private int departmentId;
	private String departmentName;
	private String position;
	private String date;
	private String state;
	
	// 생성자
	public ManagerVo() {
		
	}

	public ManagerVo(int memberId, String id, String name, String hp, String birth, String hireDate, int departmentId,
			String departmentName, String position) {
		this.memberId = memberId;
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.birth = birth;
		this.hireDate = hireDate;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.position = position;
	}
	
	public ManagerVo(int memberId, String id, String name, String hp, String birth, String hireDate, int departmentId,
			String departmentName, String position, String date, String state) {
		this.memberId = memberId;
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.birth = birth;
		this.hireDate = hireDate;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.position = position;
		this.date = date;
		this.state = state;
	}

	// 메소드 g/s
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	// 메소드 일반
	@Override
	public String toString() {
		return "ManagerVo [memberId=" + memberId + ", id=" + id + ", name=" + name + ", hp=" + hp + ", birth=" + birth
				+ ", hireDate=" + hireDate + ", departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", position=" + position + ", date=" + date + ", state=" + state + "]";
	}
	
}
