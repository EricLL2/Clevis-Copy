package hk.edu.polyu.comp.comp2021.clevis.dto;

import hk.edu.polyu.comp.comp2021.clevis.enums.Errors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/// The class responsible for processing different commands of the application
public class InputDto {
    /**
     * Process the parameters of the rectangle command.
     *
     * @param command: the command written by the user.
     *
     * @return {@code RectangleParams} object carrying the parameters of the command if the command is valid
     */
    public RectangleParams processRectangleCommand(String command) {
        Scanner input = new Scanner(command);
        input.next();

        String n = this.procesName(input);

        double[] params = new double[4];
        for (int i = 0; i < params.length; i++) {
            params[i] = this.processDouble(input);
            if (i >= 2) this.validateLength(params[i]);
        }

        this.closeCommand(input);
        return new RectangleParams(n, params[0], params[1], params[2], params[3]);
    }

    /**
     * Process the parameters of the line command.
     *
     * @param command: the command written by the user.
     *
     * @return {@code LineParams} object carrying the parameters of the command if the command is valid
     */
    public LineParams processLineCommand(String command) {
        Scanner input = new Scanner(command);
        input.next();

        String n = this.procesName(input);

        double[] params = new double[4];
        for (int i = 0; i < params.length; i++) params[i] = processDouble(input);

        this.closeCommand(input);
        return new LineParams(n, params[0], params[1], params[2], params[3]);
    }

    /**
     * Process the parameters of the circle command.
     *
     * @param command: the command written by the user.
     *
     * @return {@code CircleParams} object carrying the parameters of the command if the command is valid
     */
    public CircleParams processCircleCommand(String command) {
        Scanner input = new Scanner(command);
        input.next();

        String n = this.procesName(input);

        double[] params = new double[3];
        for (int i = 0; i < params.length; i++) {
            params[i] = this.processDouble(input);
            if (i == 2) this.validateLength(params[i]);
        }

        this.closeCommand(input);
        return new CircleParams(n, params[0], params[1], params[2]);
    }

    /**
     * Process the parameters of the square command.
     *
     * @param command: the command written by the user.
     *
     * @return {@code SquareParams} object carrying the parameters of the command if the command is valid
     */
    public SquareParams processSquareCommand(String command) {
        Scanner input = new Scanner(command);
        input.next();

        String n = this.procesName(input);

        double[] params = new double[3];
        for (int i = 0; i < params.length; i++)
            params[i] = this.processDouble(input);
        this.validateLength(params[2]);

        this.closeCommand(input);
        return new SquareParams(n, params[0], params[1], params[2]);
    }

    /**
     * Process the parameters of the group command.
     *
     * @param command: the command written by the user.
     *
     * @return {@code GroupParams} object carrying the parameters of the command if the command is valid
     */
    public GroupParams processGroupCommand(String command) {
        Scanner input = new Scanner(command);
        input.next();

        String n = this.procesName(input);

        List<String> shapeNamesList = new ArrayList<>();
        while (input.hasNext()) {
            String shapeName = input.next();
            if (shapeName != null && !shapeName.isEmpty())
                shapeNamesList.add(shapeName);
        }

        this.closeCommand(input);
        String[] shapeNames = shapeNamesList.toArray(new String[0]);

        return new GroupParams(n, shapeNames);
    }

    /**
     * Process the parameters of the ungroup command.
     *
     * @param command: the command written by the user.
     *
     * @return {@code UngroupParams} object carrying the parameters of the command if the command is valid
     */
    public UngroupParams processUngroupCommand(String command) {
        Scanner input = new Scanner(command);
        input.next();

        String n = this.procesName(input);

        this.closeCommand(input);
        return new UngroupParams(n);
    }

    /**
     * Process the parameters of the delete command.
     *
     * @param command: the command written by the user.
     *
     * @return {@code DeleteParams} object carrying the parameters of the command if the command is valid
     */
    public DeleteParams processDeleteCommand(String command) {
        Scanner input = new Scanner(command);
        input.next();

        String n = this.procesName(input);

        this.closeCommand(input);
        return new DeleteParams(n);
    }

    /**
     * Process the parameters of the boundingbox command.
     *
     * @param command: the command written by the user.
     *
     * @return {@code BoundingboxParams} object carrying the parameters of the command if the command is valid
     */
    public BoundingBoxParams processBoundBoxCommand(String command) {
        Scanner input = new Scanner(command);
        input.next();

        String n = this.procesName(input);

        this.closeCommand(input);
        return new BoundingBoxParams(n);
    }

    /**
     * Process the parameters of the move command.
     *
     * @param command: the command written by the user.
     *
     * @return {@code MoveParams} object carrying the parameters of the command if the command is valid
     */
    public MoveParams processMoveCommand(String command) {
        Scanner input = new Scanner(command);
        input.next();

        String n = this.procesName(input);

        double[] params = new double[2];
        for (int i = 0; i < params.length; i++) params[i] = this.processDouble(input);

        this.closeCommand(input);
        return new MoveParams(n, params[0], params[1]);
    }

    /**
     * Process the parameters of the shapeAt command.
     *
     * @param command: the command written by the user.
     *
     * @return {@code ShapeAtParams} object carrying the parameters of the command if the command is valid
     */
    public ShapeAtParams processShapeAtCommand(String command) {
        Scanner input = new Scanner(command);
        input.next();

        double[] params = new double[2];
        for (int i = 0; i < params.length; i++) params[i] = this.processDouble(input);

        this.closeCommand(input);
        return new ShapeAtParams(params[0], params[1]);
    }

    /**
     * Process the parameters of the intersect command.
     *
     * @param command: the command written by the user.
     *
     * @return {@code IntersectParams} object carrying the parameters of the command if the command is valid
     */
    public IntersectParams processIntersectCommand(String command) {
        Scanner input = new Scanner(command);
        input.next();

        String n1 = this.procesName(input);
        String n2 = this.procesName(input);

        this.closeCommand(input);
        return new IntersectParams(n1, n2);
    }

    /**
     * Process the parameters of the list command.
     *
     * @param command: the command written by the user.
     *
     * @return {@code ListParams} object carrying the parameters of the command if the command is valid
     */
    public ListParams processListCommand(String command) {
        Scanner input = new Scanner(command);
        input.next();

        String n = this.procesName(input);

        this.closeCommand(input);
        return new ListParams(n);
    }

    /**
     * Validate commands that don't have parameters
     *
     * @param command: the command written by the user.
     */
    public void validSingleCommand(String command) {
        Scanner input = new Scanner(command);
        input.next();
        this.closeCommand(input);
    }

    private String procesName(Scanner input) {
        if (!input.hasNext())
            throw new IllegalArgumentException(Errors.INVALID_FORMAT.getMessage());

        String n = input.next();
        if (n == null || n.isEmpty())
            throw new IllegalArgumentException(Errors.INVALID_FORMAT.getMessage());
        return n;
    }

    private double processDouble(Scanner input) {
        if (!input.hasNextDouble())
            throw new IllegalArgumentException(Errors.INVALID_FORMAT.getMessage());

        return input.nextDouble();
    }

    private void closeCommand(Scanner input) {
        if (input.hasNext())
            throw new IllegalArgumentException(Errors.INVALID_FORMAT.getMessage());
    }

    private void validateLength(double number) {
        if (number <= 0)
            throw new IllegalArgumentException(Errors.INVALID_LENGTH.getMessage());
    }
}
