import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import NewQuestionnaire from "../views/NewQuestionnaire.vue";
import NewestQuestionnairies from "@/views/NewestQuestionnairies";
import QuestionnairiesResults from "@/views/QuestionnairiesResults";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/NewQuestionnaire",
    name: "NewQuestionnaire",
    component: NewQuestionnaire
  },
  {
    path: "/NewestQuestionnairies",
    name: "NewestQuestionnairies",
    component: NewestQuestionnairies
  },
  {
    path: "/QuestionnairiesResults",
    name: "QuestionnairiesResults",
    component: QuestionnairiesResults
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
