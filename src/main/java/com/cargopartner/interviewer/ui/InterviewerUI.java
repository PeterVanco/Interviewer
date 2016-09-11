package com.cargopartner.interviewer.ui;

import com.cargopartner.interviewer.boundary.QuestionGetDAO;
import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.inject.Inject;
import java.util.logging.Logger;

@Theme("mytheme")
@CDIUI(value = "ui")
public class InterviewerUI extends UI {

    private final static Logger LOG = Logger.getLogger(InterviewerUI.class.getSimpleName());

    @Inject
    private QuestionGetDAO questionGetDAO;
    @Inject
    private InterviewForm interviewForm;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        HorizontalSplitPanel panel = new HorizontalSplitPanel();
        panel.setFirstComponent(interviewForm);
        panel.setFirstComponent(getQuestionsLayout());

        setContent(interviewForm);
    }

    private VerticalLayout getQuestionsLayout() {

        final VerticalLayout layout = new VerticalLayout();

        questionGetDAO.getQuestions().forEach(question -> {
            layout.addComponent(new Label(question.getQuestion()));
        });

        return layout;
    }

}
