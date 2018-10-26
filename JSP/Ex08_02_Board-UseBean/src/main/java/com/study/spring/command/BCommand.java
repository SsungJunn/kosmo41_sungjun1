package com.study.spring.command;

import org.springframework.ui.Model;

public interface BCommand {
//	public void execute(HttpServletRequest request,	HttpServletResponse response);

	void execute(Model model);
}
