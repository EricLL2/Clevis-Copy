package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.controller.*;
import hk.edu.polyu.comp.comp2021.clevis.dto.*;
import hk.edu.polyu.comp.comp2021.clevis.enums.Errors;
import hk.edu.polyu.comp.comp2021.clevis.view.*;

import java.util.Scanner;

/// The implementation of the clevis application
public class Clevis {
    final private InputDto dto;
    final private ShapeController controller;
    final private GuiView guiView;
    final private View view;
    final private Scanner input;

    /**
     * Constructor of the {@code Clevis} class
     *
     * @param htmlPath provided path for the html file to be logged to.
     * @param txtPath provided path for txt file to be logged to
     */
    public Clevis(String htmlPath, String txtPath) {
        this.guiView = new GuiView();
        this.view = new View(new CommandView(), this.guiView);
        this.dto = new InputDto();
        this.controller = new ShapeController(new CommandLogger(htmlPath, txtPath), this.view);
        this.input = new Scanner(System.in);
    }

    /// Start running the clevis application.
    public void start() {
        guiView.setCommandListener(() -> {
            String command = guiView.getInput();
            if (!command.isEmpty()) {
                this.processSingleCommand(command);
                guiView.focusInput();
                guiView.refreshDrawing();
            }
        });
        guiView.refreshDrawing(); // Initial drawing on startup

        while (true) {
            String command = this.input.nextLine();
            this.processSingleCommand(command);
        }
    }

    private void rectangle(String command) {
        try {
            RectangleParams params = this.dto.processRectangleCommand(command);
            this.controller.createRectangle(params, command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void line(String command) {
        try {
            LineParams params = this.dto.processLineCommand(command);
            this.controller.createLine(params, command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void circle(String command) {
        try {
            CircleParams params = this.dto.processCircleCommand(command);
            this.controller.createCircle(params, command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void square(String command) {
        try {
            SquareParams params = this.dto.processSquareCommand(command);
            this.controller.createSquare(params, command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void group(String command) {
        try {
            GroupParams params = this.dto.processGroupCommand(command);
            this.controller.createGroup(params, command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void ungroup(String command) {
        try {
            UngroupParams params  = this.dto.processUngroupCommand(command);
            this.controller.ungroup(params, command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void delete(String command) {
        try {
            DeleteParams params = this.dto.processDeleteCommand(command);
            this.controller.delete(params, command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void boundingBox(String command) {
        try {
            BoundingBoxParams params = this.dto.processBoundBoxCommand(command);
            this.controller.displayBoundingBox(params, command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void move (String command) {
        try {
            MoveParams params = this.dto.processMoveCommand(command);
            this.controller.move(params, command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void shapeAt(String command) {
        try {
            ShapeAtParams params = this.dto.processShapeAtCommand(command);
            this.controller.displayShapeAt(params, command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void intersect(String command) {
        try {
            IntersectParams params = this.dto.processIntersectCommand(command);
            this.controller.checkIntersection(params, command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void list(String command) {
        try {
            ListParams params = this.dto.processListCommand(command);
            this.controller.listOne(params, command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void listAll(String command) {
        try {
            this.dto.validSingleCommand(command);
            this.controller.listAll(command);
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void undo(String command) {
        try {
            this.dto.validSingleCommand(command);
            this.controller.undo();
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void redo(String command) {
        try {
            this.dto.validSingleCommand(command);
            this.controller.redo();
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void quit(String command) {
        try {
            this.dto.validSingleCommand(command);
            this.controller.quit();
        } catch (Exception exception) {
            this.view.displayMessage(exception.getMessage());
        }
    }

    private void processSingleCommand(String command) {
        if (command == null || command.trim().isEmpty()){
            return;
        }
        String[] commandparts = command.trim().split("\\s+");

        switch (commandparts[0]) {
            case "rectangle":
                rectangle(command);
                break;
            case "line":
                line(command);
                break;
            case "circle":
                circle(command);
                break;
            case "square":
                square(command);
                break;
            case "group":
                group(command);
                break;
            case "ungroup":
                ungroup(command);
                break;
            case "delete":
                delete(command);
                break;
            case "boundingbox":
                boundingBox(command);
                break;
            case "move":
                move(command);
                break;
            case "shapeAt":
                shapeAt(command);
                break;
            case "intersect":
                intersect(command);
                break;
            case "list":
                list(command);
                break;
            case "listAll":
                listAll(command);
                break;
            case "undo":
                undo(command);
                break;
            case "redo":
                redo(command);
                break;
            case "quit":
                quit(command);
                break;
            default:
                this.view.displayMessage(Errors.INVALID_COMMAND.getMessage());
                break;
        }
    }
}
