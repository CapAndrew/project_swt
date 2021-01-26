package ru.swt.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.swt.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

	@BeforeMethod
	public void ensurePreconditions(){
		app.goTO().groupPage();
		if (app.group().list().size() == 0) {
			app.group().createGroup(new GroupData()
							.setName("test3")
							.setHeader("test2")
							.setFooter("test3")
			);
		}
	}

	@Test
	public void testGroupModification() {
		List<GroupData> before = app.group().list();
		int index = before.size() - 1;
		GroupData group = new GroupData()
						.setId(before.get(index).getId())
						.setName("test4")
						.setHeader("test5")
						.setFooter("test6");

		app.group().modify(index, group);

		List<GroupData> after = app.group().list();
		Assert.assertEquals(after.size(), before.size());

		before.remove(index);
		before.add(group);

		Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
		before.sort(byId);
		after.sort(byId);
		Assert.assertEquals(before,after);
	}


}
