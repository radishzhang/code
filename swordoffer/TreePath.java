import java.util.ArrayList;

public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
        if (root == null) {
            return pathList;
        }
        ArrayList<Integer> path = new ArrayList<>();
        int currentSum = 0;
        FindPath(root, target, path, pathList, currentSum);
        return pathList;
    }

    public void FindPath(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> pathList,
                         int currentSum) {
        // 添加当前路径
        path.add(root.val);
        currentSum += root.val;

        // 判断是否是叶子结点
        boolean isLeft = (root.left == null && root.right == null);
        if (currentSum == target && isLeft) {
            pathList.add(new ArrayList<>(path));
        }

        // 遍历子节点
        if (root.left != null) {
            FindPath(root.left, target, path, pathList, currentSum);
        }
        if (root.right != null) {
            FindPath(root.right, target, path, pathList, currentSum);
        }

        path.remove(path.size() - 1);
        currentSum -= root.val;
    }
}
