package ru.swt.addressbook.model;

public class GroupData {
	private int id = 0;
	private String name;
	private String header;
	private String footer;

	public GroupData setId(int id) {
		this.id = id;
		return this;
	}

	public GroupData setName(String name) {
		this.name = name;
		return this;
	}

	public GroupData setHeader(String header) {
		this.header = header;
		return this;
	}

	public GroupData setFooter(String footer) {
		this.footer = footer;
		return this;
	}

	public int getId() {
		return id;
	}

	public String withName() {
		return name;
	}

	public String withHeader() {
		return header;
	}

	public String withFooter() {
		return footer;
	}

	@Override
	public String toString() {
		return "GroupData{" +
						"id='" + id + '\'' +
						", name='" + name + '\'' +
						'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		GroupData groupData = (GroupData) o;

		if (id != groupData.id) return false;
		return name != null ? name.equals(groupData.name) : groupData.name == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}
}
