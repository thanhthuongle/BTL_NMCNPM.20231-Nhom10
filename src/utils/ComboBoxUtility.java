package utils;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class ComboBoxUtility extends JComboBox<Object> {

	private static final long serialVersionUID = 1L;
	public ComboBoxUtility() {
		super();
		setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				return new BasicComboPopup(comboBox) {
					private static final long serialVersionUID = 1L;

					@Override
					protected JScrollPane createScroller() {
						JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
							@Override
							protected JButton createDecreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							protected JButton createIncreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							public Dimension getPreferredSize(JComponent c) {
								return new Dimension(10, super.getPreferredSize(c).height);
							}

							private JButton createZeroButton() {
								return new JButton() {
									private static final long serialVersionUID = 1L;

									@Override
									public Dimension getMinimumSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getPreferredSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getMaximumSize() {
										return new Dimension(new Dimension(0, 0));
									}
								};
							}
						});
						return scroller;
					}
				};
			}
		});
		setPrototypeDisplayValue("This is Text");
		setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	public ComboBoxUtility(ComboBoxModel<Object> aModel) {
		super(aModel);
		setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				return new BasicComboPopup(comboBox) {
					private static final long serialVersionUID = 1L;

					@Override
					protected JScrollPane createScroller() {
						JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
							@Override
							protected JButton createDecreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							protected JButton createIncreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							public Dimension getPreferredSize(JComponent c) {
								return new Dimension(10, super.getPreferredSize(c).height);
							}

							private JButton createZeroButton() {
								return new JButton() {
									private static final long serialVersionUID = 1L;

									@Override
									public Dimension getMinimumSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getPreferredSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getMaximumSize() {
										return new Dimension(new Dimension(0, 0));
									}
								};
							}
						});
						return scroller;
					}
				};
			}
		});
		setPrototypeDisplayValue("This is Text");
		setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	public ComboBoxUtility(Object[] items) {
		super(items);
		setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				return new BasicComboPopup(comboBox) {
					private static final long serialVersionUID = 1L;

					@Override
					protected JScrollPane createScroller() {
						JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
							@Override
							protected JButton createDecreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							protected JButton createIncreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							public Dimension getPreferredSize(JComponent c) {
								return new Dimension(10, super.getPreferredSize(c).height);
							}

							private JButton createZeroButton() {
								return new JButton() {
									/**
									 * 
									 */
									private static final long serialVersionUID = 1L;

									@Override
									public Dimension getMinimumSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getPreferredSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getMaximumSize() {
										return new Dimension(new Dimension(0, 0));
									}
								};
							}
						});
						return scroller;
					}
				};
			}
		});
		setPrototypeDisplayValue("This is Text");
		setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	public ComboBoxUtility(Vector<Object> items) {
		super(items);
		setUI(new BasicComboBoxUI() {
			@Override
			protected ComboPopup createPopup() {
				return new BasicComboPopup(comboBox) {
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					@Override
					protected JScrollPane createScroller() {
						JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
							@Override
							protected JButton createDecreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							protected JButton createIncreaseButton(int orientation) {
								return createZeroButton();
							}

							@Override
							public Dimension getPreferredSize(JComponent c) {
								return new Dimension(10, super.getPreferredSize(c).height);
							}

							private JButton createZeroButton() {
								return new JButton() {
									/**
									 * 
									 */
									private static final long serialVersionUID = 1L;

									@Override
									public Dimension getMinimumSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getPreferredSize() {
										return new Dimension(new Dimension(0, 0));
									}

									@Override
									public Dimension getMaximumSize() {
										return new Dimension(new Dimension(0, 0));
									}
								};
							}
						});
						return scroller;
					}
				};
			}
		});
		setPrototypeDisplayValue("This is Text");
		setFont(new Font("Tahoma", Font.PLAIN, 18));
	}

	public void setSelection(List<String> selections) {
		this.removeAllItems();
		for (String selection : selections) {
			this.addItem(selection);
		}
		setSelectedItem(null);
	}

	public String getSelection() {
		if (this.getSelectedIndex() == -1) {
			return "";
		}
		return this.getItemAt(this.getSelectedIndex()).toString();
	}
}