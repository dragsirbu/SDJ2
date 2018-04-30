import tasklist.controller.ClientTaskListController;
import tasklist.domain.mediator.TaskListModel;
import tasklist.domain.mediator.ClientTaskListModelManager;
import tasklist.view.ClientTaskListConsole;
import tasklist.view.TaskListView;

public class ClientMain {

    public static void main(String[] args) {

        TaskListModel model = new ClientTaskListModelManager();
        TaskListView view = new ClientTaskListConsole();
        ClientTaskListController controller = new ClientTaskListController(model,view);
        view.startView(controller);
    }
}
