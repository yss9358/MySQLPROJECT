package com.javaex.projectMySQL;

public class ManageVo {
	//필드
		private int mbId;
		private String id;
		private String name;
		private String hp;
		private String birth;
		private String hireDate;
		private int dpId;
		private String dpName;
		private String position;
		private String date;
		private String state;
		
		//생성자
		public ManageVo() {
			super();
		}

		public ManageVo(int mbId, String name, String date, String state) {
			super();
			this.mbId = mbId;
			this.name = name;
			this.date = date;
			this.state = state;
		}

		public ManageVo(int mbId, String id, String name, String hp, String birth, String hireDate, int dpId, String dpName,
				String position) {
			super();
			this.mbId = mbId;
			this.id = id;
			this.name = name;
			this.hp = hp;
			this.birth = birth;
			this.hireDate = hireDate;
			this.dpId = dpId;
			this.dpName = dpName;
			this.position = position;
		}

		
		//메소드 g/s
		public int getMbId() {
			return mbId;
		}
		
		public void setMbId(int mbId) {
			this.mbId = mbId;
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
		
		public int getDpId() {
			return dpId;
		}
		
		public void setDpId(int dpId) {
			this.dpId = dpId;
		}
		
		public String getDpName() {
			return dpName;
		}
		
		public void setDpName(String dpName) {
			this.dpName = dpName;
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

		//메소드 일반
		
		public String toString() {
			return "ManageVo [mbId=" + mbId + ", id=" + id + ", name=" + name + ", hp=" + hp + ", birth=" + birth
					+ ", hireDate=" + hireDate + ", dpId=" + dpId + ", dpName=" + dpName + ", position=" + position + "]";
		}

}
