import {Classes} from "./classes";
import {RewardAndPunishmentReason} from "./reward-and-punishment-reason";
import {FormRewardAndPunishment} from "./form-reward-and-punishment";
import {ReasonDetail} from "./reason-detail";

export interface Student {
  id? :number;
  name? :string;
  dateOfBirth? :string;
  phone? :string;
  email? :string;
  citizenIdentification? :string;
  classes: Classes;
  rewardAndPunishmentReason: RewardAndPunishmentReason
  formRewardAndPunishment: FormRewardAndPunishment
  reasonDetail: ReasonDetail
}
