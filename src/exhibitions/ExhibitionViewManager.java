package exhibitions;

import controller.dialogController.OkCancelOption;

import javax.swing.*;

/**
 * Die Klasse {@link ExhibitionViewManager} fasst die Ansichten auf Ausstellungen zusammen.
 */


public class ExhibitionViewManager {
    ExhibitionsController controller;

    public ExhibitionViewManager(ExhibitionsController controller) {
        this.controller = controller;
    }


    Thread createNewExhibitionDialog (JFrame owner){
        return new Thread ( ()-> {
            Exhibition exhibition = new Exhibition();
            ExhibitionDialog dialog = new ExhibitionDialog(owner, exhibition, true);
            dialog.setVisible(true);
            while (dialog.okCancelOption == OkCancelOption.UNDECIDED) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (dialog.okCancelOption == OkCancelOption.OK) {
                controller.addExhibition(exhibition);
            }
            dialog.dispose();
        }
        );
    }

    Thread createEditExhibitionDialog (JFrame owner, Exhibition exhibition, ExhibitionPanel panel, boolean editable){
        return new Thread ( ()-> {
            ExhibitionDialog dialog = new ExhibitionDialog(owner, exhibition, editable);
            dialog.setVisible(true);
            while (dialog.okCancelOption == OkCancelOption.UNDECIDED) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            panel.revalidate();
            dialog.dispose();
        }
        );
    }

    public Exhibition selectExhibitionDialog(JDialog owner, ExhibitionsModel model){
        ExhibitionViewFrame evf = new ExhibitionViewFrame(model, true, true, true);
        evf.setVisible(true);
        while (evf.okCancelOption == OkCancelOption.UNDECIDED){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (evf.okCancelOption == OkCancelOption.OK){
            evf.dispose();
            return model.getSelectedExhibition();
        } else {
            evf.dispose();
            return null;
        }
    }

    public void createEditExhibitionsListDialog(JDialog owner, ExhibitionsModel exhibitionModel) {
        ExhibitionViewFrame evf = new ExhibitionViewFrame(exhibitionModel, false, false, false);
        evf.setLocationRelativeTo(owner);
        evf.setVisible(true);
        while (evf.okCancelOption == OkCancelOption.UNDECIDED) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        evf.dispose();
    }

    public void createExhibitionMainWindow(ExhibitionsModel exhibitionsModel){
        ExhibitionViewFrame evf = new ExhibitionViewFrame(exhibitionsModel, true, false, true);
        evf.setVisible(true);
        while (evf.okCancelOption == OkCancelOption.UNDECIDED) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        evf.dispose();
    }
}