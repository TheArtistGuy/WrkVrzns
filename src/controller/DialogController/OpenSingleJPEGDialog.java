package controller.DialogController;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Realisiert einen JFileChooser um ein einzelnes JPEG auszuwählen.
 */


public class OpenSingleJPEGDialog extends JFileChooser{

    public OpenSingleJPEGDialog()

    {
        setFileSelectionMode(FILES_AND_DIRECTORIES);
        addChoosableFileFilter(new FileNameExtensionFilter("JPEG", "jpg"));
        setAcceptAllFileFilterUsed(false);
        setMultiSelectionEnabled(false);
        setVisible(true);
    }
}
