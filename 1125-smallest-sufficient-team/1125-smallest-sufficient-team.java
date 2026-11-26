
class Solution {

    int required;
    List<Integer> result;

    public int[] smallestSufficientTeam(String[] req, List<List<String>> people) {

        int n = req.length;
        int m = people.size();

        required = (1 << n) - 1;
        result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(req[i], i);
        }

        int[] team = new int[m];

        for (int i = 0; i < m; i++) {
            int skill = 0;

            for (String s : people.get(i)) {
                skill |= (1 << map.get(s));
            }

            team[i] = skill;
        }

        find(0, team, new ArrayList<>(), 0);

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public void find(int idx, int[] team, List<Integer> temp, int mask) {

        // All required skills covered
        if (mask == required) {
            if (result.isEmpty() || temp.size() < result.size()) {
                result = new ArrayList<>(temp);
            }
            return;
        }

        if (idx >= team.length)
            return;

        // Pruning: current team cannot improve the answer
        if (!result.isEmpty() && temp.size() >= result.size())
            return;

        // Skip current person
        find(idx + 1, team, temp, mask);

        // Take current person if they add new skills
        if ((mask | team[idx]) != mask) {

            temp.add(idx);

            find(idx + 1, team, temp, mask | team[idx]);

            temp.remove(temp.size() - 1);
        }
    }
}
