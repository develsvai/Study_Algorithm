import java.util.*;

class Member implements Comparable<Member> {
    private int age;
    private String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member other) {
        if (this.age == other.age) {
            return 0;
        }
        return this.age < other.age ? -1 : 1;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<Member> members = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            members.add(new Member(age, name));
        }

        // 나이로 먼저 정렬, 나이가 같으면 가입한 순으로 정렬
        Collections.sort(members);

        for (Member member : members) {
            System.out.println(member);
        }
    }
}