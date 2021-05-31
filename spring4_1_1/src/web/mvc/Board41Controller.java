package web.mvc;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class Board41Controller extends MultiActionController{
//	<bean id = "board-controller">
//		<property name = "boardLogic">
//	<bean/>
	private Board41Logic boardLogic = null;

	public void setBoardLogic(Board41Logic boardLogic) {
		this.boardLogic = boardLogic;
	}
}
