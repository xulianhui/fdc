package com.fdc.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionContext;
import com.fdc.pojo.HouseNews;
import com.fdc.pojo.Users;
import com.fdc.service.HouseNewsService;
import com.fdc.service.UsersService;

public class HouseNewsAction {
	private HouseNews housenews;
	private HouseNewsService houseNewsService;
	private UsersService service;
	private String addstate;
	private List<File> image; // 上传的文件
	private List<String> imageFileName; // 文件名称
	private List<String> imageContentType; // 文件类型

	public List<File> getImage() {
		return image;
	}

	public void setImage(List<File> image) {
		this.image = image;
	}

	public List<String> getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(List<String> imageFileName) {
		this.imageFileName = imageFileName;
	}

	public List<String> getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(List<String> imageContentType) {
		this.imageContentType = imageContentType;
	}

	public HouseNews getHousenews() {
		return housenews;
	}

	public void setHousenews(HouseNews housenews) {
		this.housenews = housenews;
	}

	public HouseNewsService getHouseNewsService() {
		return houseNewsService;
	}

	public void setHouseNewsService(HouseNewsService houseNewsService) {
		this.houseNewsService = houseNewsService;
	}

	public String execute() throws IOException {
		String email = ((Users) ServletActionContext.getRequest().getSession()
				.getAttribute("user")).getEmail();
		int id = service.getid(email);
		// 从users表中取出email 对应的ID
		// id 为0 说明email 对应的用户不存在，强制用户重新登陆
		if (id != 0) {
			housenews.setUserId(id);
			System.out.println("执行");
			String realpath = ServletActionContext.getServletContext()
					.getRealPath("/upload");

			System.out.println("realpath: " + realpath);
			if (image != null) {
				for (int i = 0; i < image.size(); i++) {
					File savefile = new File(new File(realpath),
							System.currentTimeMillis() + housenews.getUserId()
									+ imageFileName.get(i));
					System.out.println(savefile.getPath());
					if (!savefile.getParentFile().exists()) {
						savefile.getParentFile().mkdirs();
					}
					FileUtils.copyFile(image.get(i), savefile);
					ActionContext.getContext().put("message", "文件上传成功");
					switch (i) {
					case 0:
						housenews.setImg1("upload"
								+ savefile.getPath().replace(realpath, "")
										.replace("\\", "/"));
						break;
					case 1:
						housenews.setImg2("upload"
								+ savefile.getPath().replace(realpath, "")
										.replace("\\", "/"));
						break;
					case 2:
						housenews.setImg3("upload"
								+ savefile.getPath().replace(realpath, "")
										.replace("\\", "/"));
						break;
					case 3:
						housenews.setImg4("upload"
								+ savefile.getPath().replace(realpath, "")
										.replace("\\", "/"));
						break;
					case 4:
						housenews.setImg5("upload"
								+ savefile.getPath().replace(realpath, "")
										.replace("\\", "/"));
						break;
					case 5:
						housenews.setImg6("upload"
								+ savefile.getPath().replace(realpath, "")
										.replace("\\", "/"));
						break;
					default:
						break;
					}
				}
			}
			addstate = houseNewsService.add(housenews);
			System.out.println(housenews.getHouseAddDetail());
		} else {
			ActionContext.getContext().getSession().clear();
			return "error";
		}
		return "success";

	}

	public String getAddstate() {
		return addstate;
	}

	public void setAddstate(String addstate) {
		this.addstate = addstate;
	}

	public UsersService getService() {
		return service;
	}

	public void setService(UsersService service) {
		this.service = service;
	}
}
