import {Student} from "./student";
import {RewardAndPunishmentReason} from "./reward-and-punishment-reason";

export interface ReasonDetail {
  id? :number;
  dateOfOccurrence? :string;
  status? :number;
  student: Student;
  rewardAndPunishmentReason: RewardAndPunishmentReason;

}
