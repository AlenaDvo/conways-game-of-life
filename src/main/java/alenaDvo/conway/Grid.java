package alenaDvo.conway;

public class Grid {
    private final String[][] grid;
    private final String dead = " ";
    private final static String live = "X";

    public Grid(int rows, int columns) {
        //        fill grid with dead elements
        grid = new String[rows][columns];
        fillDead();


        //        fill grid with live elements (seed as defined)
        grid[getMidRow() - 1][getMidColumn() - 2] = live;
        grid[getMidRow()][getMidColumn() - 1] = live;
        grid[getMidRow() - 2][getMidColumn() - 1] = live;
        grid[getMidRow() - 1][getMidColumn() - 1] = live;
        grid[getMidRow()][getMidColumn()] = live;
    }

    private class Cell {
        private final int x;
        private final int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isAlive() {
            if (isInBounds()) {
                return grid[x][y].equals(live);
            } else {
                return false;
            }
        }

        public void setLive() {
            grid[x][y] = live;
        }

        public void setDead() {
            grid[x][y] = dead;
        }

        public int getNumberOfLiveNeighbours() {
            int liveNeighbours = 0;
            for (Direction direction : Direction.values()) {
                Cell neighbour = new Cell(x + direction.getX(), y + direction.getY());
                if (neighbour.isAlive()) {
                    liveNeighbours++;
                }
            }
            return liveNeighbours;
        }

        private boolean isInBounds() {
            return x >= 0 && x < getRows() &&
                    y >= 0 && y < getColumns();
        }
    }

    private int getMidRow() {
        return grid.length / 2;
    }

    private int getMidColumn() {
        return grid[0].length / 2;
    }

    private int getRows() {
        return grid.length;
    }

    private int getColumns() {
        return grid[0].length;
    }

    private void fillDead() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                grid[i][j] = dead;
            }
        }
    }

    public void print() {
        for (String[] row : grid) {
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public Grid getNextState() {
        Grid newGrid = new Grid(getRows(), getColumns());

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                Cell cell = new Cell(i, j);
                Cell newCell = newGrid.new Cell(i, j);
                if (cell.isAlive()) {
                    if (cell.getNumberOfLiveNeighbours() == 2 || cell.getNumberOfLiveNeighbours() == 3) {
                        newCell.setLive();
                    } else {
                        newCell.setDead();
                    }
                } else {
                    if (cell.getNumberOfLiveNeighbours() == 3) {
                        newCell.setLive();
                    } else {
                        newCell.setDead();
                    }
                }
            }
        }
        return newGrid;
    }
}